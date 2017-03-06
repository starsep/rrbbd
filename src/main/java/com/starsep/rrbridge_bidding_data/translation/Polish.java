package com.starsep.rrbridge_bidding_data.translation;

import com.starsep.rrbridge_bidding_data.core.Main;

class Polish implements ITranslation {
    @Override
    public String bwsDescription() {
        return "Plik BWS";
    }

    @Override
    public String version() {
        return "wersja";
    }

    @Override
    public String language() {
        return "Język";
    }

    @Override
    public String choose() {
        return "Wybierz";
    }

    @Override
    public String bwsLabel() {
        return "Lokalizacja pliku BWS";
    }

    @Override
    public String directory() {
        return "Katalog roboczy RRBridge";
    }

    @Override
    public String usage() {
        String result = "Użycie: \"wywołanie programu\" katalog_rrb plik_bws czas\n";
        result += "Gdzie:\n";
        result += "\twywołanie programu to albo \"java -jar jarFilename.jar\", albo\n";
        result += "\t\t\"java Main\"\n";
        result += "\tkatalog_rrb to nazwa katalogu, w którym są pliki wygenerowane przez RRBridge\n";
        result += "\tplik_bws to nazwa pliku z bazą danych BWS zawierającą tabelę BiddingData z licytacją\n";
        result += "\tczas to czas [w sekundach], odczekiwany po każdym wygenerowaniu plików z licytacją\n";
        result += "\t\taby wygenerować tylko raz użyj -1\n";
        result += "Dodatkowe flagi:\n";
        result += "\t" + Main.ENGLISH_FLAG + " = język angielski\n";
        result += "\t" + Main.POLISH_FLAG + " = język polski\n";
        result += "\t" + Main.NO_GUI_FLAG + " = uruchom " + consoleMode() + "\n";
        return result;
    }

    @Override
    public String launching() {
        return "Uruchamiam";
    }

    @Override
    public String guiMode() {
        return "w trybie graficznym (GUI)";
    }

    @Override
    public String consoleMode() {
        return "w trybie konsolowym";
    }

    @Override
    public String insufficientArgumentsNumberError() {
        return error() + ": niewystarczająca liczba argumentów!";
    }

    @Override
    public String error() {
        return "Błąd";
    }
}