package CalculateMenuActivity.MaterialAdapter

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rantekscalc.AppPrefs
import com.example.rantekscalc.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MaterialBottomSheet(private val onMaterialSelected: (String, Int) -> Unit) : BottomSheetDialogFragment() {

    private lateinit var appPrefs: AppPrefs
    private lateinit var materials: List<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appPrefs = AppPrefs(requireContext())

        materials = listOf(
            appPrefs.getMaterial1NameKey(),
            appPrefs.getMaterial2NameKey(),
            appPrefs.getMaterial3NameKey(),
            appPrefs.getMaterial4NameKey()
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMaterials)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = MaterialAdapter(materials) { material ->
            val price = getMaterialPrice(material)
            onMaterialSelected(material, price)
        }

        recyclerView.adapter = adapter
    }

    private fun getMaterialPrice(material: String): Int {
        return when (material) {
            appPrefs.getMaterial1NameKey() -> appPrefs.getMaterial1PriceKey().toIntOrNull() ?: 40
            appPrefs.getMaterial2NameKey() -> appPrefs.getMaterial2PriceKey().toIntOrNull() ?: 41
            appPrefs.getMaterial3NameKey() -> appPrefs.getMaterial3PriceKey().toIntOrNull() ?: 42
            appPrefs.getMaterial4NameKey() -> appPrefs.getMaterial4PriceKey().toIntOrNull() ?: 43
            else -> 0
        }
    }
}
