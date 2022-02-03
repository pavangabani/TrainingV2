package socketprogramming.datagram.onetoone;

import java.io.IOException;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        InetAddress ip=InetAddress.getByName("localhost");

        String message="\n" +
                "Jump to navigationJump to search\n" +
                "Welcome to Wikipedia,\n" +
                "the free encyclopedia that anyone can edit.\n" +
                "6,447,405 articles in English\n" +
                "The artsBiographyGeographyHistoryMathematicsScienceSocietyTechnologyAll portals\n" +
                "From today's featured article\n" +
                "Edward III of England\n" +
                "Edward III of England\n" +
                "Burnt Candlemas was a failed invasion of Scotland in early 1356 by an English army commanded by King Edward III (pictured), and was the last campaign of the Second War of Scottish Independence. Tensions on the Anglo-Scottish border led to a military build-up in 1355. In September a nine-month truce was agreed, and most of the English left. A few days later the Scots invaded and devastated Northumberland. In early November, the Scots escaladed the walls of Berwick-on-Tweed, captured the town and laid siege to its castle. The English army retook the town and marched on Edinburgh, leaving a trail of devastation 50 to 60 miles (80 to 100 km) wide. The Scots refused battle and practised a scorched earth policy, removing or destroying all food in their own territory. The English burnt Edinburgh and thoroughly despoiled Lothian. Edward's army was supplied by sea, but a winter storm scattered his fleet, forcing the English to withdraw. In 1357 a permanent peace was agreed, largely on English terms. (Full article...)\n" +
                "\n" +
                "Recently featured: SMS OldenburgDelichonBenedetto Pistrucci\n" +
                "ArchiveBy emailMore featured articles\n" +
                "Did you know ...\n" +
                "Luke Kunin\n" +
                "Luke Kunin\n" +
                "... that in 2016, Luke Kunin (pictured) became the first sophomore captain of the Wisconsin Badgers men's ice hockey team since 1975?\n" +
                "... that despite experiencing midnight sun and polar night, Svalbard observes daylight saving time?\n" +
                "... that a work by Bettie Freshwater Pool was proposed to be the official state song of North Carolina?\n" +
                "... that after viewing the Coates round house, the prospective occupant's fiancée refused to marry him unless the canal company made the property more habitable?\n" +
                "... that Qadi al-Fadil began his career under the Fatimids, became Saladin's chief minister, and was renowned for the elegance of his epistolary writing?\n" +
                "... that George Balanchine only started working on his ballet Mozartiana three weeks before its premiere?\n" +
                "... that the spotted lanternfly has been used in traditional Chinese medicine to treat swelling since the 1100s?\n" +
                "... that the Connecticut Valley Railroad successfully fooled the New York, New Haven and Hartford Railroad into purchasing it by pretending that it planned to expand northwards?\n" +
                "ArchiveStart a new articleNominate an article\n" +
                "In the news\n" +
                "António Costa in 2017\n" +
                "António Costa\n" +
                "The Socialist Party, led by António Costa (pictured), wins a majority of seats in the Portuguese legislative election.\n" +
                "Sergio Mattarella is re-elected as president of Italy.\n" +
                "In Burkina Faso, a coup d'état led by military officer Paul-Henri Sandaogo Damiba deposes President Roch Marc Christian Kaboré.\n" +
                "Vietnamese Thiền Buddhist monk and peace activist Thích Nhất Hạnh dies at the age of 95.\n" +
                "Ongoing: COVID-19 pandemic\n" +
                "Recent deaths: Norma WatersonS. K. ParamasivanLeonard FentonJeff InnisDavid GreenHarry Steele\n" +
                "Nominate an article\n" +
                "On this day\n" +
                "February 2: Groundhog Day in Canada and the United States\n" +
                "\n" +
                "Vineyard in Stellenbosch, South Africa\n" +
                "Vineyard in Stellenbosch, South Africa\n" +
                "506 – Alaric II, King of the Visigoths, promulgated a collection of Roman law known as the Breviary of Alaric.\n" +
                "1659 – Jan van Riebeeck, the founder of Cape Town, produced the first bottle of South African wine (vineyard pictured).\n" +
                "1913 – New York City's Grand Central Terminal, the world's largest train station by number of platforms, opened immediately after midnight.\n" +
                "1942 – The first act of the Norwegian resistance movement took place with the bombing of Oslo East Station by the Osvald Group to protest the inauguration of Vidkun Quisling.\n" +
                "2009 – Omid, Iran's first domestically made satellite, was successfully launched from Semnan Space Center.\n" +
                "Judith Quiney (b. 1585)José Guadalupe Posada (b. 1852)Alfred Delp (d. 1945)\n" +
                "More anniversaries: February 1February 2February 3\n" +
                "ArchiveBy emailList of days of the year\n" +
                "Today's featured picture\n" +
                "Alice Locke Park\t\n" +
                "Alice Locke Park (February 2, 1861 – October 17, 1961) was an American suffragist and a defender of women's rights. She served as associate director of the Susan B. Anthony Memorial Committee of California. This photograph of Park, from the records of the National Woman's Party, was taken around the 1910s.\n" +
                "\n" +
                "Photograph credit: unknown; restored by Adam Cuerden\n" +
                "\n" +
                "Recently featured: Valerie ThomasDuke Humfrey's LibrarySwallow-tailed bee-eater\n" +
                "ArchiveMore featured pictures\n" +
                "Other areas of Wikipedia\n" +
                "Community portal – Bulletin board, projects, resources and activities covering a wide range of Wikipedia areas.\n" +
                "Help desk – Ask questions about using Wikipedia.\n" +
                "Reference desk – Serving as virtual librarians, Wikipedia volunteers tackle your questions on a wide range of subjects.\n" +
                "Site news – Announcements, updates, articles and press releases on Wikipedia and the Wikimedia Foundation.\n" +
                "Teahouse – To ask your first basic questions about contributing to Wikipedia.\n" +
                "Village pump – For discussions about Wikipedia itself, including areas for technical issues and policies.\n" +
                "Wikipedia's sister projects\n" +
                "Wikipedia is written by volunteer editors and hosted by the Wikimedia Foundation, a non-profit organization that also hosts a range of other volunteer projects:\n" +
                "\n" +
                "Commons logo Commons\n" +
                "Free media repository\n" +
                "MediaWiki logo MediaWiki\n" +
                "Wiki software development\n" +
                "Meta-Wiki logo Meta-Wiki\n" +
                "Wikimedia project coordination\n" +
                "Wikibooks logo Wikibooks\n" +
                "Free textbooks and manuals\n" +
                "Wikidata logo Wikidata\n" +
                "Free knowledge base\n" +
                "Wikinews logo Wikinews\n" +
                "Free-content news\n" +
                "Wikiquote logo Wikiquote\n" +
                "Collection of quotations\n" +
                "Wikisource logo Wikisource\n" +
                "Free-content library\n" +
                "Wikispecies logo Wikispecies\n" +
                "Directory of species\n" +
                "Wikiversity logo Wikiversity\n" +
                "Free learning tools\n" +
                "Wikivoyage logo Wikivoyage\n" +
                "Free travel guide\n" +
                "Wiktionary logo Wiktionary\n" +
                "Dictionary and thesaurus\n" +
                "Wikipedia languages\n" +
                "This Wikipedia is written in English. Many other Wikipedias are available; some of the largest are listed below.\n" +
                "\n" +
                "1,000,000+ articles\n" +
                "العربيةDeutschEspañolFrançaisItalianoNederlands日本語PolskiPortuguêsРусскийSvenskaУкраїнськаTiếng Việt中文\n" +
                "250,000+ articles\n" +
                "Bahasa IndonesiaBahasa MelayuBân-lâm-gúБългарскиCatalàČeštinaDanskEsperantoEuskaraفارسی\u200Eעברית한국어MagyarNorsk BokmålRomânăSrpskiSrpskohrvatskiSuomiTürkçe\n" +
                "50,000+ articles\n" +
                "AsturianuBosanskiEestiΕλληνικάSimple EnglishGalegoHrvatskiLatviešuLietuviųമലയാളംМакедонскиNorsk nynorskShqipSlovenčinaSlovenščinaไทย\n" +
                "Navigation menu\n" +
                "Not logged in\n" +
                "Talk\n" +
                "Contributions\n" +
                "Create account\n" +
                "Log in\n" +
                "Main PageTalk\n" +
                "ReadView sourceView history\n" +
                "Search\n" +
                "Search Wikipedia\n" +
                "SearchGo\n" +
                "Main page\n" +
                "Contents\n" +
                "Current events\n" +
                "Random article\n" +
                "About Wikipedia\n" +
                "Contact us\n" +
                "Donate\n" +
                "Contribute\n" +
                "Help\n" +
                "Learn to edit\n" +
                "Community portal\n" +
                "Recent changes\n" +
                "Upload file\n" +
                "Tools\n" +
                "What links here\n" +
                "Related changes\n" +
                "Special pages\n" +
                "Permanent link\n" +
                "Page information\n" +
                "Wikidata item\n" +
                "Print/export\n" +
                "Download as PDF\n" +
                "Printable version\n" +
                "In other projects\n" +
                "Wikimedia Commons\n" +
                "MediaWiki\n" +
                "Meta-Wiki\n" +
                "Multilingual Wikisource\n" +
                "Wikispecies\n" +
                "Wikibooks\n" +
                "Wikidata\n" +
                "Wikimania\n" +
                "Wikinews\n" +
                "Wikiquote\n" +
                "Wikisource\n" +
                "Wikiversity\n" +
                "Wikivoyage\n" +
                "Wiktionary\n" +
                "\n" +
                "Languages\n" +
                "العربية\n" +
                "বাংলা\n" +
                "Български\n" +
                "Bosanski\n" +
                "Català\n" +
                "Čeština\n" +
                "Dansk\n" +
                "Deutsch\n" +
                "Eesti\n" +
                "Ελληνικά\n" +
                "Español\n" +
                "Esperanto\n" +
                "Euskara\n" +
                "فارسی\n" +
                "Français\n" +
                "Galego\n" +
                "한국어\n" +
                "Hrvatski\n" +
                "Bahasa Indonesia\n" +
                "Italiano\n" +
                "עברית\n" +
                "ქართული\n" +
                "Latviešu\n" +
                "Lietuvių\n" +
                "Magyar\n" +
                "Македонски\n" +
                "Bahasa Melayu\n" +
                "Nederlands\n" +
                "日本語\n" +
                "Norsk bokmål\n" +
                "Norsk nynorsk\n" +
                "Polski\n" +
                "Português\n" +
                "Română\n" +
                "Русский\n" +
                "Simple English\n" +
                "Slovenčina\n" +
                "Slovenščina\n" +
                "Српски / srpski\n" +
                "Srpskohrvatski / српскохрватски\n" +
                "Suomi\n" +
                "Svenska\n" +
                "ไทย\n" +
                "Türkçe\n" +
                "Українська\n" +
                "Tiếng Việt\n" +
                "中文\n" +
                "Text is available under the Creative Commons Attribution-ShareAlike License; additional terms may apply. By using this site, you agree to the Terms of Use and Privacy Policy. Wikipedia® is a registered trademark of the Wikimedia Foundation, Inc., a non-profit organization.\n" +
                "Privacy policyAbout WikipediaDisclaimersContact WikipediaMobile viewDevelopersStatisticsCookie statementWikimedia FoundationPowered by MediaWiki";
        DatagramPacket datagramPacket=new DatagramPacket(message.getBytes(),message.length(),ip,8888);

        datagramSocket.send(datagramPacket);

        datagramSocket.receive(datagramPacket);
        String serverMessage=new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(serverMessage);
    }
}
