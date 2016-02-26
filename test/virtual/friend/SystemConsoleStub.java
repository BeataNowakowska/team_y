package virtual.friend;

import java.util.ArrayList;

public class SystemConsoleStub extends ConsoleBox
    {

        ArrayList<String> userActions = new ArrayList<String>();
        ArrayList<String> programResponse = new ArrayList<String>();

        public void addUserAction(String action)
        {
            userActions.add(action);
        }

        public void addUserActions(String [] actions)
        {
            for (String a: actions) { 
                userActions.add(a);
            }
        }

        public String getProgramResponseAtt(int index)
        {
            return programResponse.get(index);
        }

        public void write(String line)
        {
            programResponse.add(line);
        }

        public String readline()
        {
            String firstNotReadUserAction = userActions.get(0);
            userActions.remove(0);
            return firstNotReadUserAction;
        }

        public int programResporseCount()
        {
            return programResponse.size();
        }

    }

