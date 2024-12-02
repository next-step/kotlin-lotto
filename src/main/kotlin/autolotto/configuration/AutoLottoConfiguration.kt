package autolotto.configuration

import autolotto.controller.AutoLottoController
import autolotto.repository.LottoRepository
import autolotto.service.LottoService

class AutoLottoConfiguration {
    fun autoLottoController(): AutoLottoController {
        return AutoLottoController(lottoService())
    }

    fun lottoService(): LottoService {
        return LottoService(LottoRepository())
    }

    fun lottoRepository(): LottoRepository {
        return LottoRepository()
    }
}
