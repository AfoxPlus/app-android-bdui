package com.afoxplus.bdui.delivery.components

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.afoxplus.bdui.cross.extensions.getColor
import com.afoxplus.bdui.cross.extensions.getIcon
import com.afoxplus.bdui.cross.extensions.getSpacingBetweenComponents
import com.afoxplus.bdui.cross.extensions.getSpacingHorizontal
import com.afoxplus.bdui.cross.extensions.getSpacingVertical
import com.afoxplus.bdui.cross.extensions.getTypography
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.bdui.domain.entities.IconComponent
import com.afoxplus.uikit.designsystem.atoms.UIKitIcon
import com.afoxplus.uikit.designsystem.atoms.UIKitText

@Composable
fun RowIconTextHandler(gridComponent: GridComponent) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = gridComponent.getSpacingHorizontal(),
                vertical = gridComponent.getSpacingVertical()
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(gridComponent.getSpacingBetweenComponents())
    ) {
        gridComponent.items.forEach { item ->
            when (item.name) {
                "CARD_ICON" -> {
                    val icon = item.children?.first() as IconComponent
                    UIKitIcon(icon = icon.getIcon())
                }

                "CARD_TEXT" -> {
                    val uri = item.content?.get("uri").toString()
                    val text = item.content?.get("text").toString()

                    UIKitText(
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                            try {
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                Toast.makeText(
                                    context,
                                    "Error",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        text = text,
                        style = item.getTypography(),
                        color = item.getColor()
                    )
                }
            }
        }

    }
}