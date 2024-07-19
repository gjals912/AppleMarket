package com.example.AppleMarket

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.iv_profill,"프라다 복조리백","수원시 영동구 원천동","50,000원","수원시","영동구","원천동"))
        dataList.add(MyItem(R.drawable.iv_profill,"프라다 복조리백","수원시 영동구 원천동","50,000원","수원시","영동구","원천동"))
        dataList.add(MyItem(R.drawable.iv_profill,"프라다 복조리백","수원시 영동구 원천동","50,000원","수원시","영동구","원천동"))
        dataList.add(MyItem(R.drawable.iv_profill,"프라다 복조리백","수원시 영동구 원천동","50,000원","수원시","영동구","원천동"))
        dataList.add(MyItem(R.drawable.iv_profill,"프라다 복조리백","수원시 영동구 원천동","50,000원","수원시","영동구","원천동"))


        val adapter = MyAdapter(dataList,
            itemClickListener = { item, position ->
                Toast.makeText(this, "${item.ivProfill} clicked", Toast.LENGTH_SHORT).show()
                var nameIntent = Intent(this@MainActivity,Detail_Page::class.java)
                nameIntent.putExtra("name",item.ivProfill)
                startActivity(nameIntent)
            })

        binding.recycleListView.adapter = adapter
        binding.recycleListView.layoutManager = LinearLayoutManager(this@MainActivity)

    }




}


