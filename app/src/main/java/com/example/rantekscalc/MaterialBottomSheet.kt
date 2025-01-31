import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.recreate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rantekscalc.AppPrefs
import com.example.rantekscalc.MaterialAdapter
import com.example.rantekscalc.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MaterialBottomSheet(private val onMaterialSelected: (String, Int) -> Unit) : BottomSheetDialogFragment() {

    private lateinit var appPrefs: AppPrefs
    private lateinit var materials: List<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bottom_sheet_materials, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("MaterialBottomSheet", "onViewCreated called")
        appPrefs = AppPrefs(requireContext())

        Log.d("MaterialBottomSheet", "Material1: ${appPrefs.material1NameKey}")
        Log.d("MaterialBottomSheet", "Material2: ${appPrefs.material2NameKey}")
        Log.d("MaterialBottomSheet", "Material3: ${appPrefs.material3NameKey}")
        Log.d("MaterialBottomSheet", "Material4: ${appPrefs.material4NameKey}")

        materials = listOf(
        appPrefs.material1NameKey, // Получаем названия из AppPrefs
            appPrefs.material2NameKey,
            appPrefs.material3NameKey,
            appPrefs.material4NameKey
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
        val price = when (material) {
            appPrefs.material1NameKey -> appPrefs.material1PriceKey.toIntOrNull() ?: 40
            appPrefs.material2NameKey -> appPrefs.material2PriceKey.toIntOrNull() ?: 41
            appPrefs.material3NameKey -> appPrefs.material3PriceKey.toIntOrNull() ?: 42
            appPrefs.material4NameKey -> appPrefs.material4PriceKey.toIntOrNull() ?: 43
            else -> 0
        }

        Log.d("MaterialBottomSheet", "Price for $material: $price")
        return price
    }




}
