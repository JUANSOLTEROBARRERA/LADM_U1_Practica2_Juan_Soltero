package mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.CustomAdapter
import mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.databinding.FragmentGalleryBinding
import mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.ui.home.HomeFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.agregar.setOnClickListener {
            guardarArchivo()
            leerArchivo()
            binding.hamburguesa.setChecked (false);
            binding.pizza.setChecked (false);
            binding.refresco.setChecked (false);
            binding.papas.setChecked (false);
        }

        return root
    }

    private fun leerArchivo(){
        try {
            var archivo = BufferedReader(InputStreamReader(requireContext().openFileInput("archivo.txt")))
            var cadena = archivo.readLine()
            cadena = cadena.replace("&&","\n")

            AlertDialog.Builder(requireContext()).setMessage("Agregando...").show()
        }catch(e:Exception){
            AlertDialog.Builder(requireContext()).setMessage(e.message).show()
        }
    }
    private fun guardarArchivo(){
        //HomeFragmentadapter.titles.set(0,"hola")
        try {

            var archivox = BufferedReader(InputStreamReader(requireContext().openFileInput("archivo.txt")))
            var cadenax = archivox.readLine()

            var archivoz = BufferedReader(InputStreamReader(requireContext().openFileInput("archivo2.txt")))
            var cadenaz = archivoz.readLine()
            val archivo = OutputStreamWriter(requireContext().openFileOutput("archivo.txt", AppCompatActivity.MODE_PRIVATE))

            val archivo2 = OutputStreamWriter(requireContext().openFileOutput("archivo2.txt", AppCompatActivity.MODE_PRIVATE))
            var cadena = "${cadenax}"
            var cadena2 = "${cadenaz}"
            if(cadena2.equals("null")){
                cadena=""
                cadena2=""
            }

            if (binding.hamburguesa.isChecked){
                cadena+="Hamburguesa&&"
                cadena2+="Comida Rápida&&"
            }
            if (binding.pizza.isChecked){
                cadena+="Pizza&&"
                cadena2+="Comida Rápida&&"
            }
            if (binding.refresco.isChecked){
                cadena+="Refresco&&"
                cadena2+="Comida Rápida&&"
            }
            if (binding.papas.isChecked){
                cadena+="Papas&&"
                cadena2+="Comida Rápida&&"
            }
            archivo.write(cadena)
            archivo.flush()
            archivo.close()
            archivo2.write(cadena2)
            archivo2.flush()
            archivo2.close()
            //AlertDialog.Builder(requireContext()).setMessage("Agregado...").show()
        }catch (e:Exception){
            AlertDialog.Builder(requireContext()).setMessage(e.message).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}