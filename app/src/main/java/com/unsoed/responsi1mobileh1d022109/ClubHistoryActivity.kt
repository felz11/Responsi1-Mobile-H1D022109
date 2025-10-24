package com.unsoed.responsi1mobileh1d022109

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobileh1d022109.databinding.ActivityClubHistoryBinding

class ClubHistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClubHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClubHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Club History"

        displayHistory()
    }

    private fun displayHistory() {
        val historyText = """
            Early years
            
            The club began its existence in 1899 as a loose, informal group of football enthusiasts within the Hamburg-St.Pauli Turn-Verein 1862. This group did not play its first match until 1907, when they faced a similar side assembled from the local Aegir swimming club. Officially established on 15 May 1910, the club played as St. Pauli TV in the Kreisliga Groß-Hamburg (Alsterkreis) until 1924, when a separate football side called St. Pauli was formed. The team played as an undistinguished lower-to-mid table side until making their first appearance in 1934 in the top-flight Gauliga Nordmark, 1 of 16 premier level divisions created in the re-organization of German football that took place under the Third Reich. They were immediately relegated, but returned to the top flight in 1936. Relegated again in 1940, St. Pauli re-appeared in the Gauliga Hamburg in 1942, and played there until the end of World War II.
            
            Post-war football
            
            After the war, the club resumed play in the Oberliga Nord in 1947. A second-place finish in the 1947–48 season led St. Pauli to its first appearance in the national championship rounds. They advanced as far as the semi-finals, where they were knocked out 2–3 by eventual champions 1. FC Nürnberg. The club continued to play well throughout the early 1950s, but were unable to overtake rivals Hamburger SV, finishing in second place in five of the next seven seasons, and going out in the early rounds in each of their championship-round appearances from 1949 to 1951. In the late 1950s and into the early 1960s, St. Pauli were overtaken by rivals such as Werder Bremen and VfL Osnabrück, but finished fourth a number of times.
            
            Promotion to the Bundesliga
            
            In 1963, the Bundesliga – West Germany's new top-flight professional league – was formed. Hamburger SV, Werder Bremen, and Eintracht Braunschweig joined the new circuit as the top-finishers from the Oberliga Nord, while FC St. Pauli found themselves in the second-tier Regionalliga Nord. That year, the club signed Guy Acolatse, who became the first Black professional footballer to play in Germany.
            
            Nearly a decade-and-a-half of frustration followed. St. Pauli won their division in 1964, but finished bottom of their group in the promotion play-off round. They won their next Regionalliga Nord title in 1966, but, while they performed far better in the play-offs, still could not advance to the top-flight, losing to Rot-Weiss Essen on goal difference, having conceded two more goals. Division championships in 1972 and 1973, and runner-up finishes in 1971 and 1974, were each followed by promotion-round play-off disappointment.
            
            The success of the Bundesliga, and the growth of professional football in West Germany, led to the formation of the 2. Bundesliga in 1974. St. Pauli was part of the new second-tier professional circuit in the 2. Bundesliga Nord and, in 1977, they advanced to the top flight as winners of their division. The team survived for one season at the highest level in the Bundesliga.
            
            The club's return to the 2. Bundesliga Nord was also short-lived. On the verge on bankruptcy in 1979, they were denied a license for the following season and were sent down to the Oberliga Nord (III). Strong performances that set the team atop that division in 1981 and 1983 were marred by poor financial health. By 1984, the club had recovered sufficiently to return to the 2. Bundesliga, overtaking Werder Bremen's amateur side, who, despite finishing two points ahead of St. Pauli, were ineligible for promotion.
            
            "Kult" phenomenon
            
            It was in the mid-1980s that St. Pauli's transition from a standard traditional club into a "Kult" club began. The club was also able to turn the location of its ground in the dock area part of town, near Hamburg's famous Reeperbahn – centre of the city's night life and its red-light district – to its advantage. An alternative fan scene slowly emerged, built around left-leaning politics, social activism and the event and party atmosphere of the club's matches. St. Pauli became the first team in Germany to officially ban right-wing nationalist activities and displays in its stadium during a period of fascist-inspired football hooliganism across Europe. In 1981, the team was averaging small crowds of only 1,600 spectators, but by the late 1990s they were frequently selling out their entire 20,000-capacity ground.
            
            Supporters adopted the skull and crossbones as their own unofficial emblem in the 1980s. Although precise details are uncertain, the story goes that named "Doc Mabuse", a singer in a Hamburg punk band, nailed a Jolly Roger flag to a broomstick and brought it to the Millerntor-Stadion. The original flag featured a skull with pirate eyepatch. Inspired, other fans began to bring similar flags to matches. In 1989, Hamburg screenprinter Steph Braun created an image combining a detailed representation of a skull (taken from an anatomy textbook) with the words "ST. PAULI" underneath. Intended to represent the area itself, and sold in various record shops around the district, Braun's graphic was adopted by St. Pauli fans and came to be seen as specifically associated with the club.
            
            Into the new millennium
            
            Until 2010, the club's most recent appearance in the top-flight had been a single-season cameo in 2001–02. A win against Bayern Munich, the reigning Intercontinental Cup winners, led to the popular "Weltpokalsiegerbesieger" ("World Club Champion beaters") shirts. However, the team finished last in the league, partly because the management did not trust the team which surprisingly won the promotion in 2001, but rather spent the additional money from Bundesliga TV contracts and advertisements on expensive but disappointing players.
            
            During the 2005–06 season, the team enjoyed unprecedented success in the DFB-Pokal, with wins over Burghausen, VfL Bochum and, significantly, Bundesliga sides Hertha BSC and, in the quarter-finals on 25 January 2006, Werder Bremen. After success in the 2006–07 season, the team was promoted to the 2. Bundesliga. After defeating SpVgg Greuther Fürth in the 2009–10 season, the team secured promotion back to the Bundesliga for the 2010–11 season. Since then, the club remained in the 2. Bundesliga until they earned promotion back to the Bundesliga in the 2023–24 season.
        """.trimIndent()

        binding.tvHistory.text = historyText
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}