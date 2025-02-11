package com.afoxplus.bdui.demo.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.afoxplus.bdui.delivery.screens.EstablishmentDetailScreen
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UIKitTheme {
                EstablishmentDetailScreen(
                    establishmentCode = "671885a91cfe6b6e8339ea70",
                    onBack = { onBackPressedDispatcher.onBackPressed() })
            }
        }
    }
}
