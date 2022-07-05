package com.example.trabalhofinal1

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleCursorAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.navigation.fragment.findNavController
import com.example.trabalhofinal1.databinding.FragmentEditarMotoristaBinding

import com.google.android.material.snackbar.Snackbar

class EditarMotoristaFragment: Fragment(), LoaderManager.LoaderCallbacks<Cursor> {
    private var _binding: FragmentEditarMotoristaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private var motorista: Motorista? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditarMotoristaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as MainActivity
        activity.fragment = this
        activity.idMenuAtual = R.menu.menu_edicao

        if (arguments != null) {
            motorista = EditarMotoristaFragmentArgs.fromBundle(arguments!!).motorista

            if (motorista != null) {
                binding.editTextNome.setText(motorista!!.nome)
                binding.editTextDataNascimento.setText(motorista!!.dataNascimento)
                binding.editTextMorada.setText(motorista!!.morada)
                binding.editTextCc.setText(motorista!!.cc)
                binding.editTextTelemovel.setText(motorista!!.telemovel)
                binding.editTextEmail.setText(motorista!!.email)
            }
        }
    }

    fun processaOpcaoMenu(item: MenuItem) : Boolean =
        when(item.itemId) {
            R.id.action_guardar -> {
                guardar()
                true
            }
            R.id.action_cancelar -> {
                voltaListaMotorista()
                true
            }
            else -> false
        }

    private fun guardar() {
        val nome = binding.editTextNome.text.toString()
        if (nome.isBlank()) {
            binding.editTextNome.error = getString(R.string.nome_obrigatorio)
            binding.editTextNome.requestFocus()
            return
        }

        val dataNascimento = binding.editTextDataNascimento.text.toString()
        if (dataNascimento.isBlank()) {
            binding.editTextDataNascimento.error = getString(R.string.dataNascimento_obrigatorio)
            binding.editTextDataNascimento.requestFocus()
            return
        }

        val morada = binding.editTextMorada.text.toString()
        if (morada.isBlank()) {
            binding.editTextMorada.error = getString(R.string.morada_obrigatorio)
            binding.editTextMorada.requestFocus()
            return
        }

        val cc = binding.editTextCc.text.toString()
        if (morada.isBlank()) {
            binding.editTextCc.error = getString(R.string.cc_obrigatorio)
            binding.editTextCc.requestFocus()
            return
        }

        val telemovel = binding.editTextTelemovel.text.toString()
        if (morada.isBlank()) {
            binding.editTextTelemovel.error = getString(R.string.telemovel_obrigatorio)
            binding.editTextTelemovel.requestFocus()
            return
        }

        val email = binding.editTextEmail.text.toString()
        if (email.isBlank()) {
            binding.editTextEmail.error = getString(R.string.email_obrigatorio)
            binding.editTextEmail.requestFocus()
            return
        }


        val motoristaGuardado =
            if (motorista == null) {
                insereMotorista(nome, dataNascimento, morada, cc, telemovel, email)
            } else {
                alteraMotorista(nome, dataNascimento, morada, cc, telemovel, email)
            }

        if (motoristaGuardado) {
            Toast.makeText(requireContext(), R.string.motorista_guardado_sucesso, Toast.LENGTH_LONG)
                .show()
            voltaListaMotorista()
        } else {
            Snackbar.make(binding.editTextNome, R.string.erro_guardar_motorista, Snackbar.LENGTH_INDEFINITE).show()
            return
        }
    }

    private fun alteraMotorista(nome: String, dataNascimento: String, Morada: String, Cc: String, Telemovel: String, Email: String) : Boolean {
        val motorista = Motorista(nome, dataNascimento, morada, cc, telemovel, email)

        val enderecoMotorista = Uri.withAppendedPath(ContentProviderMotorista.ENDERECO_MOTORISTAS, "${this.motorista!!.id}")

        val registosAlterados = requireActivity().contentResolver.update(enderecoMotorista, motorista.toContentValues(), null, null)

        return registosAlterados == 1
    }

    private fun insereMotorista(nome: String, dataNascimento: String, Morada: String, Cc: String, Telemovel: String, Email: String): Boolean {
        val motorista = motorista(nome, dataNascimento, morada, cc, telemovel, email)

        val enderecoMotoristaInserido = requireActivity().contentResolver.insert(ContentProviderMotorista.ENDERECO_MOTORISTAS, motorista.toContentValues())

        return enderecoMotoristaInserido != null
    }

    private fun voltaListaMotorista() {
        findNavController().navigate(R.id.action_editar_motorista_to_lista_motoristas)
    }
}