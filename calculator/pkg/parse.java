package pkg;

import java.io.*;

class Consts {
    public static final boolean TK_NUM = true;
    public static final boolean TK_OP = false;
}

class Token {
    public boolean ty;
    public String val;
}

class Tokenizer {
    // Consts
    public static final boolean TK_NUM = true;
    public static final boolean TK_OP = false;

    Token[] tokens = new Token[100];
    int idx = 0;
    String tmp = "";

    Tokenizer() {
        tokens = new Token[100];
        idx = 0;
        tmp = "";
    }

    private void add_num_tokens() {
        if (tmp != "") {
            tokens[idx].ty = TK_NUM;
            tokens[idx].val = tmp;
            tmp = "";
            idx++;
        }
    }

    void tokenize(String s) {
        /* 
         * digitの場合一度tmpに足す。
         * もしTK_OPの場合tmpをtokensに追加してオペランドを追加する
         * */
        for (char c: s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                add_num_tokens();
                tokens[idx].ty = TK_OP;
                tokens[idx].val = String.valueOf(c);
                idx++;
                continue;
            }
            if (c == '(' || c == ')') {
                add_num_tokens();
                tokens[idx].ty = TK_OP;
                tokens[idx].val = String.valueOf(c);
                idx++;
                continue;
            }
            if (Character.isDigit(c)) {
               tmp += String.valueOf(c); 
            }
        }
        add_num_tokens();
    }

    Token[] get_tokens() {
        // Tokenのリストを返します
        return tokens;
    }
}

class Node {
    public boolean ty;
    public String val;
    public Node lhs;  // 左のNode
    public Node rhs;  // 右のNode
}

public class parse {

    Token[] tokens;
    int pos;

    parse(Token[] tk) {
        tokens = tk;
        pos = 0;
    }

    Node new_node(boolean ty, Node lhs, Node rhs) {
        Node node = new Node();
        node.ty = ty;
        node.lhs = lhs;
        node.rhs = rhs;
        return node;
    }

    Node new_node_num(String val) {
        Node node = new Node();
        node.ty = Consts.TK_NUM;
        node.val = val;
        return node;
    }

    // 次のトークンが期待した型かチェックして、
    // 期待した型のときはposを+!してtrueを返す
    boolean consume(boolean ty) {
        if (tokens[pos].ty != ty) {
            return false;
        }
        pos += 1;
        return true;
    }

    Node add() {
        Node node = mul();
        
        while (true) {
            if consume()
        }
    }

    Node mul() {

    }

    Node term() {

    }
}

