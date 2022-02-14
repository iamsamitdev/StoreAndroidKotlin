package com.itgenius.storeandroidkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.itgenius.storeandroidkotlin.R
import com.itgenius.storeandroidkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // การสร้างตัวแปรสำหรับทำงานกับ View Binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // หากต้องการ binding id ใดๆ ใน xml
        // binding.mainAppbar.setOnClickListener{}

        // กำหนดค่าเริ่มต้นให้กับ navController
        navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        navController = navHostFragment.navController

        // เรียกทำงานกับ Toolbar
        setSupportActionBar(binding.mainToolbar)

        // กำหนด Fragment ที่ไม่ต้องการให้แสดงปุ่ม Back
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.productFragment,
            R.id.reportFragment,
            R.id.notificationFragment,
            R.id.accountFragment
        ).setOpenableLayout(binding.mainDrawerLayout).build()

        // กำหนด Toolbar ให้แสดง icon เมนู
        setupActionBarWithNavController(navController, appBarConfiguration)

        // เรียกใช้งาน Drawer navigation
        binding.mainNavigationView.setupWithNavController(navController)

        // เรียกใช้งาน Bottom navigation
        binding.mainBottomNavigationVeiw.setupWithNavController(navController)

    }

    // สร้างฟังก์ชันเรียกซ่อน / แสดงเมนู
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}