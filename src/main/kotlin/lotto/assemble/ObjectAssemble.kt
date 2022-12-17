package lotto.assemble

import lotto.application.command.OrderTicketService
import lotto.domain.policy.DefaultPricePolicy
import lotto.interfaces.TicketController

object ObjectAssemble {

    fun executableApp() = TicketController(orderTicketService = orderTicketService())
    private fun orderTicketService() = OrderTicketService(pricePolicy = pricePolicy())
    private fun pricePolicy() = DefaultPricePolicy
}