package pkg;

enum TokenKind {
    TK_RESERVED,
    TK_NUM,
    TK_OP,
}

class Token {
    TokenKind kind;
    Token next;
    int val;
    char[] str;
}

public class Tokenizer {
    String str;
    Token token;

    Tokenizer(String s) {
        this.str = s;
        this.token = new Token();
    }

    private boolean consume(char op) {
        if (this.token.kind != TokenKind.TK_RESERVED || this.token.str[0] != op) {
            return false;
        }
        this.token = this.token.next;
        return true;
    }

    private void expect(char op) {
        if (this.token.kind != TokenKind.TK_RESERVED || this.token.str[0] != op) {
            System.out.printf("%c ではありません", op);
        }
        this.token = this.token.next;
    }

    void tokenize(String s) {
        for (char c: s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {

            }
        }
    }
}
