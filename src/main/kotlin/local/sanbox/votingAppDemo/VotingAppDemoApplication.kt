package local.sanbox.votingAppDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VotingAppDemoApplication

fun main(args: Array<String>) {
    runApplication<VotingAppDemoApplication>(*args)
}
