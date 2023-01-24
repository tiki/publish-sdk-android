package com.mytiki.tiki_sdk_android.example_app.destination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.activityViewModels
import com.mytiki.tiki_sdk_android.example_app.R
import com.mytiki.tiki_sdk_android.example_app.databinding.DestinationFragmentBinding
import com.mytiki.tiki_sdk_android.example_app.databinding.TryItOutFragmentBinding
import com.mytiki.tiki_sdk_android.example_app.try_it_out.TryItOutViewModel
import java.util.*

class DestinationFragment : Fragment() {

    private val viewModel by activityViewModels<TryItOutViewModel>()

    private var _binding: DestinationFragmentBinding? = null
    private val binding get() = _binding!!

    private var timer: Timer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.destination_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMethodSpinner()
        initIntervalSpinner()
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
            intervalSpinner.setSelection(adapter.getPosition(viewModel.stream.value?.interval.toString()))
        }
        intervalSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.stream.value?.interval = Integer.valueOf(adapter.getItem(p2).toString())
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
            methodSpinner.setSelection(adapter.getPosition(viewModel.stream.value?.httpMethod))
        }
        methodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.stream.value?.httpMethod = adapter.getItem(p2).toString()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }

}