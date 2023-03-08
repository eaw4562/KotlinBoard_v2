package com.example.kotlinboard.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinboard.R

class BoardAdapter(private val boardList: List<DataBoard>) :
    RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.board_item, parent, false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        val currentBoard = boardList[position]
        holder.boardTitle.text = currentBoard.title
        holder.boardLoc.text = currentBoard.loc
        holder.boardTime.text = currentBoard.time
        holder.boardPrice.text = currentBoard.price

        // 이미지를 설정하는 코드
      //  holder.boardImg.setImageResource(currentBoard.imageLink)
    }

    override fun getItemCount() = boardList.size

    inner class BoardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // val boardImg: ImageView = itemView.findViewById(R.id.board_img)
        val boardTitle: TextView = itemView.findViewById(R.id.board_title)
        val boardLoc: TextView = itemView.findViewById(R.id.board_loc)
        val boardTime: TextView = itemView.findViewById(R.id.board_time)
        val boardPrice: TextView = itemView.findViewById(R.id.board_price)
    }

}
