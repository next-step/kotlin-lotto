package lotto.configuration

import lotto.controller.LottoController
import lotto.repository.LottoRepository
import lotto.service.LottoService

class AutoLottoConfiguration {
    fun autoLottoController(): LottoController {
        return LottoController(lottoService())
    }

    fun lottoService(): LottoService {
        return LottoService(lottoRepository())
    }

    fun lottoRepository(): LottoRepository {
        return LottoRepository()
    }
}
