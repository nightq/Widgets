package freedom.nightq.widgets.tagview.bean;

/**
 * Created by Nightq on 16/3/2.
 */
public interface TagInfoBeanImpl {
    /**
     * 显示的内容
     * @return
     */
    public String getDisplayContent ();
    /**
     * 显示的角度
     * @return
     */
    public int getAngle ();

    /**
     * tag
     * @return
     */
    public Object getTag ();

    /**
     * is show
     * @return
     */
    public boolean isShowable ();
    /**
     *
     * @return
     */
    public float getPositionX ();
    /**
     *
     * @return
     */
    public float getPositionY ();

    /**
     *
     * @return
     */
    public void setPositionX (float positionX);
    /**
     *
     * @return
     */
    public void setPositionY (float positionY);


    /**
     * 翻转
     */
    public void flipDirection ();
}
