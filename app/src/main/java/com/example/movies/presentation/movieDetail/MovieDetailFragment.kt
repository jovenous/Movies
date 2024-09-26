package com.example.movies.presentation.movieDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.movies.R
import com.example.movies.databinding.FragmentMovieDetailBinding
import kotlinx.coroutines.launch

class MovieDetailFragment : Fragment() {

    private val viewModel: MovieDetailViewModel by viewModels()

    private var _binding: FragmentMovieDetailBinding? = null
    private val binding: FragmentMovieDetailBinding
        get() = checkNotNull(_binding) { "FragmentHomeBinding == null" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {

            binding.toolbar.setNavigationOnClickListener {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }

            viewModel.state.collect {
                when (it) {
                    MovieDetailViewModel.MovieState.Error -> {}
                    MovieDetailViewModel.MovieState.Loading -> {
                        binding.root.isVisible = false
                    }

                    is MovieDetailViewModel.MovieState.Success -> {
                        with(binding) {
                            root.isVisible = true
                            imageViewMoviePosterBg.setImageResource(it.data.imgBG)
                            imageViewMoviePosterFg.setImageResource(it.data.imgFG)
                            textViewMovieTitle.text = it.data.name
                        }

                    }
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}