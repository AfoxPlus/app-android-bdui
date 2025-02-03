package com.afoxplus.bdui.delivery.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.afoxplus.bdui.delivery.factories.BDUIFactoryBar
import com.afoxplus.bdui.delivery.factories.BDUIFactoryEstablishmentDetail
import com.afoxplus.bdui.delivery.viewmodels.EstablishmentDetailViewModel
import com.afoxplus.bdui.domain.entities.Screen
import com.afoxplus.uikit.common.UIState

@Composable
private fun EstablishmentDetail(
    modifier: Modifier = Modifier,
    viewModel: EstablishmentDetailViewModel = hiltViewModel(),
    establishmentCode: String
) {
    val componentsState by viewModel.componentsState.collectAsState()
    when (componentsState) {
        is UIState.OnError -> HandleEstablishmentDetailError()
        is UIState.OnLoading -> HandleEstablishmentDetailLoading()
        is UIState.OnSuccess -> HandleEstablishmentDetail(
            modifier,
            (componentsState as UIState.OnSuccess<Screen>).data
        )
    }
    LaunchedEffect(Unit) { viewModel.callGetEstablishmentDetail(establishmentCode) }
}

@Composable
private fun HandleEstablishmentDetailLoading() {

}

@Composable
private fun HandleEstablishmentDetail(
    modifier: Modifier = Modifier,
    screen: Screen
) {
    Scaffold(
        modifier = modifier,
        topBar = { screen.topBar?.let { BDUIFactoryBar(it) } },
        bottomBar = { screen.bottomBar?.let { BDUIFactoryBar(it) } }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            items(
                count = screen.content.size,
                key = { screen.content[it].id }
            ) {
                BDUIFactoryEstablishmentDetail(screen.content[it])
            }
        }
    }
}


@Composable
private fun HandleEstablishmentDetailError() {

}

@Composable
fun EstablishmentDetailScreen(
    modifier: Modifier = Modifier,
    establishmentCode: String
) {
    EstablishmentDetail(
        modifier = modifier,
        establishmentCode = establishmentCode
    )
}
