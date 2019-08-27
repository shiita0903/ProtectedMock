package jp.shiita.protectedmock

import com.nhaarman.mockitokotlin2.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ViewModelTest {
    @Test
    fun loadData() {
        val id = 10
        // invokeからexecuteが呼び出されるようにするため、mockではなくspyを使う
        val useCase = spy(ConcreteUseCase(mock(), mock()))
        doReturn(ResultData(100, "hoge"))
            .whenever(useCase)
            .execute(any())    // protectedは呼び出せないので拡張関数を定義する
        val viewModel = ViewModel(id, useCase)

        val actual = viewModel.loadData()

        assertThat(actual).isEqualTo("100:hoge")
        verify(useCase, times(1)).invoke(id)
    }
}