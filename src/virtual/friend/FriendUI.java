package virtual.friend;

    public class FriendUI
    {

        public static String HELP = "I can help you in many ways, press:\n"+ 
            "c - if you want me to cheer you up,\n"+
            "a - if you're stuck, I'll ask you something,\n"+
            "e - excersize your brain,\n"+
            "p - for puzzles,\n"+
            "s - for science questions,\n"+
            "h - display this help,\n"+
            "q - if you want me to leave.\n"+
            "And press Enter\n";

        public static String GREETING = "Hello, " + HELP;
        public static String BYEBYE = "Bye bye!";
        public static String UNKNOWN_COMMAND = "I don't have such functionality";
        public static String NOT_IMPLEMENTED_YET = "Coming soon...";


        ConsoleBox console;
        QuestionsPrinter questionPrinter;
        QuotesPrinter quotesPrinter;
        ScienceTestPrinter scienceTestPrinter;
        PuzzlesPrinter puzzlesPrinter;
        
        public FriendUI(ConsoleBox console, QuestionsPrinter askMeSomethingChooser, QuotesPrinter quotesPrinter, ScienceTestPrinter scienceTestPrinter, PuzzlesPrinter puzzlesPrinter)
        {
            this.console = console;
            this.quotesPrinter = quotesPrinter;
            this.questionPrinter = askMeSomethingChooser;
            this.scienceTestPrinter = scienceTestPrinter;
            this.puzzlesPrinter = puzzlesPrinter;
        }

        public void run()
        {
            console.write(GREETING);
            String answer;
            do
            {
                answer = console.readline();

                switch (answer)
                {
                    case "c":
                        quotesPrinter.next();
                    	break;
                    case "a":
                    	questionPrinter.next();
                        break;
                    case "s":
                    	scienceTestPrinter.next();
                        break;
                    case "p":
                    	puzzlesPrinter.next();
                        break;
                    case "e":
                        console.write(NOT_IMPLEMENTED_YET);
                        break;
                    case "h":
                        console.write(HELP);
                        break;
                    case "q":
                        console.write(BYEBYE);
                        break;
                    default:
                        console.write(UNKNOWN_COMMAND);
                        break;
                }
            } while (!answer.equals("q"));
        }
    }
