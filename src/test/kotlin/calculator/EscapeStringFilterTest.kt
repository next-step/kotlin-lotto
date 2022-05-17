package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

// run
class EscapeStringFilterTest : DescribeSpec({

    // excluded
    describe("include escape string \\n") {
        // excluded
        context("something...") {
            // excluded
            it("something...") {
                true shouldBe true
            }
        }
    }

    // run
    describe("something...") {
        // excluded
        context("include escape string \\n") {
            // excluded
            it("something true") {
                true shouldBe true
            }
        }

        // run
        context("something ...") {
            // run
            it("include escape string \\n") {
                true shouldBe true
            }
        }
    }
})
