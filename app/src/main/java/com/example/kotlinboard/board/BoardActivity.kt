package com.example.kotlinboard.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinboard.R
import com.example.kotlinboard.databinding.ActivityBoardBinding

class BoardActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBoardBinding
    private lateinit var boardAdapter: BoardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //툴바 설정
        var toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        //툴바에 메뉴 등록
        val menu = toolbar.menu
        menuInflater.inflate(R.menu.item_toolbar, menu)

        //RecyclerView 설정
        binding.mRecyclerView.setHasFixedSize(true) //크기가 변경되지 않음 false : 변경됨
        binding.mRecyclerView.layoutManager = LinearLayoutManager(this)

        //데이터 생성


        // 어댑터 생성 및 RecyclerView에 설정
        boardAdapter = BoardAdapter(DummyBoardData.listOfBoard)
        binding.mRecyclerView.adapter = boardAdapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_toolbar, menu)
        return true
    }


}