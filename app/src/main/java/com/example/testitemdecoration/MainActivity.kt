package com.example.testitemdecoration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testitemdecoration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dateAdapter: DateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dateAdapter = DateAdapter()
        binding.dateRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = dateAdapter
        }
        dateAdapter.submitList(getDataDate())

        binding.dateRecyclerView.run {
            clearDecorations()
            addItemDecoration(
                ScheduleTimeHeadersDecoration(
                    context,
                    getDataDate()
                )
            )
        }
    }

    private fun getDataDate(): List<DateModel> {
        return mutableListOf(
            DateModel(1, "2:30 AM", "title 1", "Dec 1"),
            DateModel(2, "2:30 AM", "title 2", "Dec 2"),
            DateModel(3, "2:30 AM", "title 3", "Dec 3"),
            DateModel(4, "2:30 AM", "title 4", "Dec 4"),
            DateModel(5, "2:30 AM", "title 5", "Dec 5"),
            DateModel(6, "22:30 AM", "title 6", "Dec 6"),
            DateModel(7, "22:30 AM", "title 7", "Dec 7"),
            DateModel(8, "23:30 AM", "title 8", "Dec 8"),
            DateModel(9, "23:30 AM", "title 9", "Dec 9"),
            DateModel(10, "23:30 AM", "title 10", "Dec 10"),
            DateModel(11, "23:30 AM", "title 12", "Dec 12"),
            DateModel(12, "23:30 AM", "title 13", "Dec 13"),
            DateModel(13, "23:30 AM", "title 14", "Dec 14"),
            DateModel(14, "23:30 AM", "title 15", "Dec 15"),
            DateModel(15, "23:30 AM", "title 16", "Dec 16"),
            DateModel(16, "23:30 AM", "title 17", "Dec 17"),
            DateModel(17, "23:30 AM", "title 18", "Dec 18")
        )
    }
}