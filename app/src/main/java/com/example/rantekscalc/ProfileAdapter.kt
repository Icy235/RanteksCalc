package com.example.rantekscalc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProfileAdapter(
    private val profiles: MutableList<Profile>,
    private val onDeleteClick: (Int) -> Unit,
    private val onProfileClick: (Profile) -> Unit,
    private val onProfileChangeListener: (Int, Profile) -> Unit // Коллбэк для изменений
) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: EditText = itemView.findViewById(R.id.editTextProfileName) // Изменили на EditText
        val workload: EditText = itemView.findViewById(R.id.editTextWorkLoad)
        val client: EditText = itemView.findViewById(R.id.editTextClient)
        val totalPrice: TextView = itemView.findViewById(R.id.viewTextTotalProfile)
        val deleteButton: ImageButton = itemView.findViewById(R.id.btnDeleteProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profiles[position]
        holder.name.setText(profile.name) // Устанавливаем текст в EditText
        holder.workload.setText(profile.workload)
        holder.client.setText(profile.client)
        holder.totalPrice.text = profile.totalPrice

        // Обработчик удаления профиля
        holder.deleteButton.setOnClickListener {
            onDeleteClick(position)
        }

        // Обработчик нажатия на профиль
        holder.itemView.setOnClickListener {
            onProfileClick(profile)
        }

        // Сохранение изменений в имени заказа
        holder.name.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                profile.name = holder.name.text.toString()
                onProfileChangeListener(position, profile)
            }
        }

        // Сохранение изменений в workload
        holder.workload.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                profile.workload = holder.workload.text.toString()
                onProfileChangeListener(position, profile)
            }
        }

        // Сохранение изменений в client
        holder.client.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                profile.client = holder.client.text.toString()
                onProfileChangeListener(position, profile)
            }
        }
    }

    override fun getItemCount(): Int = profiles.size
}