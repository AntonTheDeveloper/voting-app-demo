package local.sanbox.votingAppDemo.web

import local.sanbox.votingAppDemo.web.dto.Vote
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.UnsupportedOperationException
import java.time.LocalDate

@RestController
@RequestMapping("/api")
class VotingController {

    private val votingStartDate = LocalDate.of(2020, 6, 24)
    private val votingEndDate = LocalDate.of(2020, 7, 2)

    /**
     * curl -i -X POST localhost:1984/api/greeting
     */
    @GetMapping("/greeting")
    fun getGreeting() = "Glory to Arstotzka!"

    /**
     * curl -i -X POST localhost:1984/api/is-it-voting-day
     */
    @PostMapping("/is-it-voting-day")
    fun isItVotingDay() =
        LocalDate
            .now()
            .let {
                val after = it.isAfter(this.votingStartDate)
                val before = it.isBefore(this.votingEndDate)
                after && before
            }

    /**
     * curl -H "content-type: application/json" -i -X POST -d '{"agree": true}' localhost:1984/api/vote
     */
    @PostMapping("/vote")
    fun saveVote(@RequestBody vote: Vote): String {
        if (vote.agree) {
            return "Your vote has been accepted. Thank you comrade. Glory to Arstotzka!"
        } else {
            return this.dispatchPartyvan()
        }
    }

    private fun dispatchPartyvan(): String {
        throw UnsupportedOperationException("not implemented") // fixme: not implemented yet
        // todo:
        //  find citizen's location
        //  dispatch Special Weapons Assault Team
        //  notify Office of Investigation
        //  return further instructions for citizen
    }
}