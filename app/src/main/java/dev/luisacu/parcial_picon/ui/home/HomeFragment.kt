package dev.luisacu.parcial_picon.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import dev.luisacu.parcial_picon.R
import dev.luisacu.parcial_picon.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container,false)
        val root: View = binding.root

        val inputVuelo: EditText = root.findViewById(R.id.inputVuelo)
        val inputAloj: EditText = root.findViewById(R.id.inputAloj)
        val inputNoche: EditText = root.findViewById(R.id.inputNoche)
        val inputComida: EditText = root.findViewById(R.id.inputComida)
        val buttonCalculate: Button = root.findViewById(R.id.buttonCalculate)
        val textResult: TextView = root.findViewById(R.id.txtResult)

        buttonCalculate.setOnClickListener {
            calculatePresupuesto(inputVuelo, inputAloj, inputNoche, inputComida, textResult)
        }
        return root
    }

    private fun calculatePresupuesto(inputVuelo: EditText,inputAloj:EditText, inputNoche: EditText,inputComida:EditText,textResult:TextView){
        val vuelo = inputVuelo.text.toString().toDoubleOrNull() ?: 0.0
        val aloj = inputAloj.text.toString().toDoubleOrNull() ?: 0.0
        val noche = inputNoche.text.toString().toDoubleOrNull() ?: 1.0
        val comida = inputComida.text.toString().toDoubleOrNull() ?: 0.0

        val presupuesto = vuelo + (aloj*noche)+(comida*noche)

        textResult.text = "El presupuesto total es:${String.format("%.2f",presupuesto)}"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}