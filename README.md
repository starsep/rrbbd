# English README
## Usage
```
Usage: "program execution" rrb_directory bws_filename time
Where:
	program execution is either "java -jar jarFilename.jar" or
		"java com.starsep.rrbridge_bidding_data.core.Main"
	rrb_directory is directory where RRBridge output is
	bws_filename is filename of BWS database containing BiddingData
	time is time [in seconds] to wait after every files generation
		to generate once use -1
Additional flags:
	--english = English language
	--polish = Polish language
	--no-gui = launch in non-GUI (console) mode
```

# Polskie README
## Użycie
```
Użycie: "wywołanie programu" katalog_rrb plik_bws czas
Gdzie:
	wywołanie programu to albo "java -jar jarFilename.jar", albo
		"java com.starsep.rrbridge_bidding_data.core.Main"
	katalog_rrb to nazwa katalogu, w którym są pliki wygenerowane przez RRBridge
	plik_bws to nazwa pliku z bazą danych BWS zawierającą tabelę BiddingData z licytacją
	czas to czas [w sekundach], odczekiwany po każdym wygenerowaniu plików z licytacją
		aby wygenerować tylko raz użyj -1
Dodatkowe flagi:
	--english = język angielski
	--polish = język polski
	--no-gui = uruchom w trybie konsolowym
```
