package mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.tecnm.tepic.ladm_u1_practica2_juan_soltero.databinding.FragmentSlideshowBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.agregar1.setOnClickListener {
            guardarArchivo()
            leerArchivo()
            binding.hamburguesa1.setChecked (false);
            binding.pizza1.setChecked (false);
            binding.refresco1.setChecked (false);
            binding.papas1.setChecked (false);
        }
        return root
    }

    private fun leerArchivo(){
        try {
            var archivo = BufferedReader(InputStreamReader(requireContext().openFileInput("archivo.txt")))
            var cadena = archivo.readLine()
            cadena = cadena.replace("&&","\n")

            AlertDialog.Builder(requireContext()).setMessage("Actualizando...").show()
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
            var cadena=""
            var cadena2=""

            if (binding.hamburguesa1.isChecked){
                cadena+="Hamburguesa&&"
                cadena2+="Comida Rápida&&"
            }
            if (binding.pizza1.isChecked){
                cadena+="Pizza&&"
                cadena2+="Comida Rápida&&"
            }
            if (binding.refresco1.isChecked){
                cadena+="Refresco&&"
                cadena2+="Comida Rápida&&"
            }
            if (binding.papas1.isChecked){
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