package com.example.simplemvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.simplemvvm.R
import com.example.simplemvvm.databinding.FragmentQuoteBinding
import com.example.simplemvvm.viewmodel.QuoteViewModel

class QuoteFragment : Fragment() {

    // Binding amb les views del layout XML (fragment_quote.xml)
    private var _binding: FragmentQuoteBinding? = null
    private val binding get() = _binding!!

    // Instanciem el ViewModel amb "by" (NO amb el constructor), així el ViewModel
    // es conserva davant canvis d'estat i no perdem la informació.
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Llegim la variable de lectura del ViewModel (sense el guió baix _)
        // i en posem el contingut a les views.
        quoteViewModel.quoteModel.observe(viewLifecycleOwner, Observer { quote ->
            binding.tvQuote.text = quote.quote
            binding.tvAuthor.text = quote.author
        })

        // Des de la instància del ViewModel cridem la funció que genera dades.
        binding.btnNewQuote.setOnClickListener { quoteViewModel.randomQuote() }
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

        // Navegació cap al segon Fragment (acció definida a navigation.xml)
        binding.btnAllQuotes.setOnClickListener {
            findNavController().navigate(R.id.action_quoteFragment_to_quoteListFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // evitem fuites de memòria
    }
}
