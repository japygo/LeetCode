class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());

        int index = 0;
        while (index < formula.length()) {
            if (formula.charAt(index) == '(') {
                stack.push(new TreeMap<>());
                index += 1;
            } else if (formula.charAt(index) == ')') {
                Map<String, Integer> poppedMap = stack.pop();
                index += 1;
                StringBuilder digits = new StringBuilder();
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    digits.append(formula.charAt(index));
                    index += 1;
                }
                if (!digits.isEmpty()) {
                    int multiple = Integer.parseInt(digits.toString());
                    poppedMap.replaceAll((k, v) -> v * multiple);
                }
                for (Map.Entry<String, Integer> entry : poppedMap.entrySet()) {
                    String atom = entry.getKey();
                    stack.peek().put(atom, stack.peek().getOrDefault(atom, 0) + entry.getValue());
                }
            } else {
                StringBuilder atom = new StringBuilder();
                do {
                    atom.append(formula.charAt(index));
                    index += 1;
                } while (index < formula.length() && Character.isLowerCase(formula.charAt(index)));
                StringBuilder digits = new StringBuilder();
                while (index < formula.length() && Character.isDigit(formula.charAt(index))) {
                    digits.append(formula.charAt(index));
                    index += 1;
                }
                int count = digits.isEmpty() ? 1 : Integer.parseInt(digits.toString());
                stack.peek().put(atom.toString(), stack.peek().getOrDefault(atom.toString(), 0) + count);
            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : stack.peek().entrySet()) {
            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());
            }
        }

        return result.toString();
    }
}