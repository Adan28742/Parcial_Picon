package dev.luisacu.parcial_picon.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.luisacu.parcial_picon.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var listViewTeams: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        listViewTeams = binding.listViewTeams
        val teams = arrayOf(
            "GlobeGuard Inssuarance",
            "SafeJourney Coverage",
            "TravelShield Protection",
            "VoyageSecure",
            "WanderSure Travel Insurance"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, teams)
        listViewTeams.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}