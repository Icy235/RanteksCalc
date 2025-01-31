package com.example.rantekscalc

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MaterialAdapter(
    private val materials: List<String>,
    private val onMaterialSelected: (String) -> Unit
) : RecyclerView.Adapter<MaterialAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.textMaterial)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_material, parent, false)
        return ViewHolder(view)
        Log.d("MaterialBottomSheet", "onViewCreated called")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val material = materials[position]
        holder.textView.text = material
        holder.itemView.setOnClickListener {
            onMaterialSelected(material)

            Log.d("MaterialBottomSheet", "material called")// Выбираем материал
        }
    }

    override fun getItemCount() = materials.size
}
