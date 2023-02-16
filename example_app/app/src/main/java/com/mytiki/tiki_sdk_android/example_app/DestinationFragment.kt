package com.mytiki.tiki_sdk_android.example_app

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mytiki.tiki_sdk_android.example_app.databinding.DestinationFragmentBinding
import java.util.*

class DestinationFragment : Fragment() {

    private val viewModel by activityViewModels<HomeViewModel>()

    private var _binding: DestinationFragmentBinding? = null
    private val binding get() = _binding!!

    private var timer: Timer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DestinationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMethodSpinner()
        initIntervalSpinner()
        binding.url.setText(viewModel.url.value)
        binding.url.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.url.value = s.toString()
            }
        })
    }

    private fun initIntervalSpinner() {
        val intervalSpinner: Spinner = binding.interval
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.interval,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            intervalSpinner.adapter = adapter
            intervalSpinner.setSelection(adapter.getPosition(viewModel.interval.value?.toString()))
        }
        intervalSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.interval.value = Integer.valueOf(adapter.getItem(p2).toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

    private fun initMethodSpinner() {
        val methodSpinner: Spinner = binding.method
        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.http_methods,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            methodSpinner.adapter = adapter
            methodSpinner.setSelection(adapter.getPosition(viewModel.httpMethod.value))
        }
        methodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.httpMethod.value = adapter.getItem(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

}