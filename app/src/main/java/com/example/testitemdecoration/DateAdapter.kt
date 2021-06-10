package com.example.testitemdecoration

import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testitemdecoration.databinding.ItemDateBinding

class DateAdapter : ListAdapter<DateModel, DateViewHolder>(SessionDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        return DateViewHolder(
            ItemDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object SessionDiff : DiffUtil.ItemCallback<DateModel>() {

    override fun areItemsTheSame(oldItem: DateModel, newItem: DateModel): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DateModel, newItem: DateModel): Boolean =
        oldItem == newItem
}

class DateViewHolder(private val binding: ItemDateBinding) : RecyclerView.ViewHolder(binding.root) {
    var isExpanded = false
    private var expandedIds = mutableSetOf<Int>()

    fun bind(item: DateModel) {
        isExpanded = expandedIds.contains(item.id)
        binding.titleTextView.text = item.title
        binding.decTextView.text = item.titleDetail
        updateView(isExpanded)
        itemView.setOnClickListener {
            val parent = itemView.parent as? ViewGroup ?: return@setOnClickListener
            val expanded = isExpanded
            if (expanded) {
                expandedIds.remove(item.id)
            } else {
                expandedIds.add(item.id)
            }

            val transition = TransitionInflater.from(itemView.context)
                .inflateTransition(R.transition.codelab_toggle)
            TransitionManager.beginDelayedTransition(parent, transition)

            isExpanded = !expanded

            updateView(isExpanded)
        }
    }

    private fun updateView(isExpanded: Boolean) {
        if (isExpanded) {
            binding.expandIcon.rotationX = 180f
            binding.codelabDescription.visibility = View.VISIBLE
        } else {
            binding.expandIcon.rotationX = 0f
            binding.codelabDescription.visibility = View.GONE
        }
    }
}
