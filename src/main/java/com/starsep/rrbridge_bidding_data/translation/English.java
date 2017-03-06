package com.starsep.rrbridge_bidding_data.translation;

import com.starsep.rrbridge_bidding_data.core.Arguments;
import com.starsep.rrbridge_bidding_data.core.Main;

class English implements ITranslation {

    @Override
    public String bwsDescription() {
        return "BWS File";
    }

    @Override
    public String version() {
        return "version";
    }

    @Override
    public String language() {
        return "Language";
    }

    @Override
    public String choose() {
        return "Choose";
    }

    @Override
    public String bwsLabel() {
        return "BWS Localization";
    }

    @Override
    public String directory() {
        return "RRBridge work directory";
    }

    @Override
    public String usage() {
        String result = "Usage: \"program execution\" rrb_directory bws_filename time\n";
        result += "Where:\n";
        result += "\tprogram execution is either \"java -jar jarFilename.jar\" or\n";
        result += "\t\t\"java Main\"\n";
        result += "\trrb_directory is directory where RRBridge output is\n";
        result += "\tbws_filename is filename of BWS database containing BiddingData\n";
        result += "\ttime is time [in seconds] to wait after every files generation\n";
        result += "\t\tto generate once use -1\n";
        result += "Additional flags:\n";
        result += "\t" + Arguments.ENGLISH_FLAG + " = English language\n";
        result += "\t" + Arguments.POLISH_FLAG + " = Polish language\n";
        result += "\t" + Arguments.NO_GUI_FLAG + " = launch " + consoleMode() + "\n";
        return result;
    }

    @Override
    public String launching() {
        return "Launching";
    }

    @Override
    public String guiMode() {
        return "in GUI mode";
    }

    @Override
    public String consoleMode() {
        return "in non-GUI (console) mode";
    }

    @Override
    public String insufficientArgumentsNumberError() {
        return error() + ": insufficient arguments number!";
    }

    @Override
    public String error() {
        return "Error";
    }
}
