int[] stack = new int[S.length()];
        int top = -1;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (Character.isDigit(c)) {
                // If the character is a digit, push it to the stack
                stack[++top] = c - '0';
            } else {
                // The character is an operator, pop two elements from stack
                int a = stack[top--];
                int b = stack[top--];

                switch (c) {
                    case '+':
                        stack[++top] = b + a;
                        break;
                    case '-':
                        stack[++top] = b - a;
                        break;
                    case '*':
                        stack[++top] = b * a;
                        break;
                    case '/':
                        stack[++top] = b / a;
                        break;
                }
            }
        }

        // The result is the only element left in the stack
        return stack[top];
    
