import Model.Game.*;
import Model.Tiles.*;
import View.GUI;
import Controller.Controller;


public class Tester {
    public static void main(String[] args){

        GUI g = new GUI();

        /*
        Controller cont = new Controller();
        Bag hello = new Bag();
        Tile geia = new AmphoraTile(AmphoraTileColor.BLUE);
        Tile geia1 = new AmphoraTile(AmphoraTileColor.BROWN);
        Tile geia2 = new AmphoraTile(AmphoraTileColor.RED);
        Tile geia3 = new AmphoraTile(AmphoraTileColor.GREEN);
        Tile geia4 = new AmphoraTile(AmphoraTileColor.YELLOW);
        Tile geia5 = new AmphoraTile(AmphoraTileColor.PURPLE);
        Tile geia6 = new AmphoraTile(AmphoraTileColor.BLUE);
        Tile geia7 = new AmphoraTile(AmphoraTileColor.BROWN);
        Tile geia8 = new AmphoraTile(AmphoraTileColor.RED);
        hello.addTile(geia);
        hello.addTile(geia1);
        hello.addTile(geia2);
        hello.addTile(geia3);
        hello.addTile(geia4);
        hello.addTile(geia5);
        hello.addTile(geia6);
        hello.addTile(geia7);
        hello.addTile(geia8);
        cont.getP1().setPlayersTiles(hello);
        cont.getP1().playersPoints();
        System.out.println(cont.getP1());

        //Board board = new Board();
        //cont.drawTilesFromBag(cont.getBag(), cont.getP1().getPlayersTiles());
        //cont.drawTilesFromBag(cont.getBag(), cont.getP1().getPlayersTiles());
        //board.addToAreas(cont.getP1().getPlayersTiles());

        //cont.drawTilesFromBag(cont.getBag(), cont.getP2().getPlayersTiles());
        //cont.drawTilesFromBag(cont.getBag(), cont.getP2().getPlayersTiles());
        //board.addToAreas(cont.getP2().getPlayersTiles());

        //cont.drawTilesFromBag(cont.getBag(), cont.getP3().getPlayersTiles());
        //cont.drawTilesFromBag(cont.getBag(), cont.getP3().getPlayersTiles());
        //board.addToAreas(cont.getP3().getPlayersTiles());

        //cont.drawTilesFromBag(cont.getBag(), cont.getP4().getPlayersTiles());
        //cont.drawTilesFromBag(cont.getBag(), cont.getP4().getPlayersTiles());
        //board.addToAreas(cont.getP4().getPlayersTiles());
        /*
        cont.getP1().playersPoints();
        cont.getP2().playersPoints();
        cont.getP3().playersPoints();
        cont.getP4().playersPoints();

        cont.getP1().initSphinx();
        cont.getP2().initSphinx();
        cont.getP3().initSphinx();
        cont.getP4().initSphinx();

        cont.getP1().initCaryatid();
        cont.getP2().initCaryatid();
        cont.getP3().initCaryatid();
        cont.getP4().initCaryatid();

        cont.assignSphinxPoints();
        cont.assignCaryatidPoints();

        System.out.println(cont.getP1());
        System.out.println(cont.getP2());
        System.out.println(cont.getP3());
        System.out.println(cont.getP4());

        System.out.println(cont.gameWinner());
        //System.out.println(board);

        /* Statue Points Test
        Controller cont = new Controller();

        Bag hello = new Bag();
        Tile geia = new StatueTile("Sphinx");
        Tile geia1 = new StatueTile("Sphinx");
        Tile geia2 = new StatueTile("Sphinx");
        hello.addTile(geia);
        hello.addTile(geia1);
        hello.addTile(geia2);
        cont.getP1().setPlayersTiles(hello);

        Bag a = new Bag();
        Tile p = new StatueTile("Caryatid");
        Tile p2 = new StatueTile("Caryatid");
        Tile p3 = new StatueTile("Sphinx");
        Tile p4 = new StatueTile("Sphinx");
        a.addTile(p);
        a.addTile(p2);
        a.addTile(p3);
        a.addTile(p4);
        cont.getP2().setPlayersTiles(a);

        Bag poios = new Bag();
        Tile plero = new StatueTile("Caryatid");
        Tile plero1 = new StatueTile("Caryatid");
        Tile plero2 = new StatueTile("Sphinx");
        poios.addTile(plero);
        poios.addTile(plero1);
        poios.addTile(plero2);
        cont.getP3().setPlayersTiles(poios);

        Bag b = new Bag();
        Tile t = new StatueTile("Sphinx");
        Tile t1 = new StatueTile("Sphinx");
        b.addTile(t);
        b.addTile(t1);
        cont.getP4().setPlayersTiles(b);

        cont.getP4().initCaryatid();
        cont.getP3().initCaryatid();
        cont.getP2().initCaryatid();
        cont.getP1().initCaryatid();

        cont.getP4().initSphinx();
        cont.getP3().initSphinx();
        cont.getP2().initSphinx();
        cont.getP1().initSphinx();

        cont.assignCaryatidPoints();
        cont.assignSphinxPoints();

        System.out.println(cont.getP1());
        System.out.println(cont.getP2());
        System.out.println(cont.getP3());
        System.out.println(cont.getP4());
        */

        //Bag poios = new Bag();
        //poios.init_tiles();
        //System.out.println("GameBag before: " + poios);

        //Player antwnhs = new Player(PlayerColor.BLUE, "antwnhs");
        //antwnhs.initPlayer();

        /*
        Tile geia = new SkeletonTile("Adult", "Lower");
        Tile geia1 = new SkeletonTile("Adult", "Upper");
        Tile geia2 = new SkeletonTile("Adult", "Lower");
        Tile geia3 = new SkeletonTile("Kid", "Upper");
        Tile geia4 = new SkeletonTile("Kid", "Lower");
        Tile geia5 = new SkeletonTile("Adult", "Lower");
        Tile geia6 = new MosaicTile(MosaicTileColor.RED);
        Tile geia7 = new MosaicTile(MosaicTileColor.YELLOW);
        Tile geia8 = new MosaicTile(MosaicTileColor.YELLOW);
        Tile geia9 = new MosaicTile(MosaicTileColor.YELLOW);
        hello.addTile(geia);
        hello.addTile(geia1);
        hello.addTile(geia2);
        hello.addTile(geia3);
        hello.addTile(geia4);
        hello.addTile(geia5);
        hello.addTile(geia6);
        hello.addTile(geia7);
        hello.addTile(geia8);
        hello.addTile(geia9);

        System.out.println("PlayerBag before: " + hello);

        Board alepou = new Board();
        Turn gkei = new Turn();
        gkei.drawTilesFromBag(poios, hello);
        System.out.println("GameBag after: " + poios);
        System.out.println("PlayerBag after: " + hello);

        alepou.addToAreas(hello);
        System.out.println("PlayerBag after after: " + hello);
        System.out.println(alepou);

        antwnhs.setPlayersTiles(hello);
        antwnhs.playersPoints();
        System.out.println(antwnhs);
        */
        //GUI egw = new GUI(500, 100);
        //egw.setUpGUI();
    }
}
