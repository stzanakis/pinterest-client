package eu.europeana.model;

import eu.europeana.common.Tools;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardsData {
    @XmlElement(name = "data")
    private Board[] boards;
    private Page page;

    public BoardsData() {
    }

    public BoardsData(Board[] boards, Page page) {
        this.boards = boards;
        this.page = page;
    }

    public Board[] getBoards() {
        return boards;
    }

    public void setBoards(Board[] boards) {
        this.boards = boards;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        try {
            return Tools.marshallAny(this);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }
}
