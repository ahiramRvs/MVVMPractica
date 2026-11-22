package com.example.simplemvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.simplemvvm.databinding.FragmentQuoteListBinding
import com.example.simplemvvm.viewmodel.QuoteListViewModel

class QuoteListFragment : Fragment() {

    private var _binding: FragmentQuoteListBinding? = null
    private val binding get() = _binding!!

    // ViewModel instanciat amb "by"
    private val quoteListViewModel: QuoteListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Llegim la variable de lectura (quotes) i la mostrem a la view
        quoteListViewModel.quotes.observe(viewLifecycleOwner, Observer { quotes ->
            binding.tvQuotes.text = quotes.joinToString(separator = "\n\n") {
                "\"${it.quote}\"\n— ${it.author}"
            }
        })

        // Funció del ViewModel que genera les dades
        quoteListViewModel.loadQuotes()

        binding.btnBack.setOnClickListener { findNavController().popBackStack() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
