package mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.CustomAdapter
import mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.databinding.FragmentHomeBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //AGREGAR AL HOME--------------
        val rec = binding.recyclerView
        val adapter = CustomAdapter()

        rec.layoutManager = LinearLayoutManager(requireContext())
        rec.adapter = adapter


        try {
            var archivo = BufferedReader(InputStreamReader(requireContext().openFileInput("archivo.txt")))
            var cadena = archivo.readLine()
            //var cadena = cadena.replace("&&","$")
            //val delim = "$"
            var arr1 = cadena.split("&&")
            //var ccadena = arrayOf(cadena.split(delim).toString())
            var archivo2 = BufferedReader(InputStreamReader(requireContext().openFileInput("archivo2.txt")))
            var cadena2 = archivo2.readLine()
            //cadena2 = cadena2.replace("&&","$")
            //cadena2 = cadena2.split(delim).toString()
            var arr2 = cadena2.split("&&")
            (0..arr1.size-2).forEach {
                adapter.titles.set(it, arr1[it])
                adapter.details.set(it, arr2[it])
            }
        }catch(e:Exception){
            //AlertDialog.Builder(requireContext()).setMessage(e.message).show()
        }
        AlertDialog.Builder(requireContext()).setMessage("El siguiente " +
                "programa cuenta con todas las funciones del CRUD, en el " +
                "menú izquierdo se puede ver la orden, insertar alimentos" +
                ", y actualizarlos, para eliminar la orden se da click " +
                "sobre la burbuja de la parte inferior derecha de la pantalla.").show()

        //adapter.titles.set(0,cadena)
        //------------------------------

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}