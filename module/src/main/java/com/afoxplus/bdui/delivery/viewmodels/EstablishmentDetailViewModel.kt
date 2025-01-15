package com.afoxplus.bdui.delivery.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.usecases.GetEstablishmentDetail
import com.afoxplus.uikit.common.ResultState
import com.afoxplus.uikit.common.UIState
import com.afoxplus.uikit.di.UIKitCoroutineDispatcher
import com.afoxplus.uikit.exceptions.UIException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class EstablishmentDetailViewModel @Inject constructor(
    private val getEstablishmentDetail: GetEstablishmentDetail,
    private val dispatcher: UIKitCoroutineDispatcher
) : ViewModel() {

    private val mComponentsState = MutableStateFlow<UIState<List<Component>>>(UIState.OnLoading())
    val componentsState = mComponentsState.asStateFlow()

    fun callGetEstablishmentDetail(establishmentCode: String) {
        viewModelScope.launch(dispatcher.getIODispatcher()) {
            when (val result = getEstablishmentDetail(establishmentCode)) {
                is ResultState.Success -> {
                    mComponentsState.value = UIState.OnSuccess(result.data)
                }

                is ResultState.Error -> {
                    mComponentsState.value = UIState.OnError(UIException(ERROR_GET_ESTABLISHMENT))
                }
            }
        }
    }

    companion object {
        private const val ERROR_GET_ESTABLISHMENT =
            "Error al cargar detalles del establecimiento. Intente de nuevo."
    }

}