package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.CartItemBinding

class CartAdapter(private val cartItems: MutableList<String>, private val cartItemPrices: MutableList<String>, private val CartImage: MutableList<Int>): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {


    private val itemQuantity = IntArray(cartItems.size) { 1 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartAdapter.CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = cartItems.size
    inner class CartViewHolder(private val binding: CartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantity[position]
                cartFoodName.text = cartItems[position]
                cartItemPrice.text = cartItemPrices[position]
                cartImage.setImageResource(CartImage[position])
                cartItemquantity.text = quantity.toString()

                minusButton.setOnClickListener {
                    decreaseQuantity(position)
                }
                plusButton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    deleteItem(position)
                }
            }
        }

        private fun increaseQuantity(position: Int) {
            if (  itemQuantity[position] < 10) {
                itemQuantity[position]++
                binding.cartItemquantity.text = itemQuantity[position].toString()
            }
        }
        private fun decreaseQuantity(position: Int) {
            if (  itemQuantity[position] > 1) {
                itemQuantity[position]--
                binding.cartItemquantity.text = itemQuantity[position].toString()
            }
        }
        private fun deleteItem(position: Int) {
            cartItems.removeAt(position)
            cartItemPrices.removeAt(position)
            CartImage.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, cartItems.size)
        }
    }
}