package pojo;

/**
 *  Created by Administrator on 2017/12/20 0020.
 */
public class EasyUITreeNode {

    private Long id;
    private String text;
    private String state; // 节点状态："closed" 表示父节点， "open" 表示叶子节点

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
