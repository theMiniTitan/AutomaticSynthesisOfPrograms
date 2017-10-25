import Cartesian.CartesianNode;
import Cartesian.Genotype;
import Evolution.Tree;
import Graph.Graph;
import Graph.Scanner;

import java.util.Random;

/**
 * Created by Brendan on 16/10/2017.
 */
public class MainCartesian {

//0 12 16 0 9 0 1 17 3 1 72 0 1 77 7 2 45 15 2 40 17 2 42 3 2 58 3 0 17 10 0 64 4 9 34 1 8 35 3 5 86 2 7 90 8 9 54 10 2 59 9 16 77 5 0 27 14 12 47 14 11 89 0 1 33 8 3 12 4 9 46 5 10 81 5 1 0 10 7 56 16 13 85 13 18 3 15 16 105 12 4 101 6 24 89 15 4 14 18 7 45 15 26 89 8 15 8 9 7 66 13 18 116 2 21 106 5 14 42 1 16 108 11 31 61 8 29 121 16 0 64 14 32 47 4 6 76 1 32 71 6 29 57 3 17 26 18 18 51 10 16 90 16 38 53 5 21 14 6 27 14 0 49 119 7 51 116 11 19 24 10 9 55 4 24 79 15 41 29 11 44 34 11 38 113 2 31 99 8 23 130 1 30 37 16 47 47 0 1 73 1 29 51 12 27 104 1 16 95 4 29 106 11 68 46 0 52 65 16 19 134 5 13 57 13 43 88 12 31 25 2 17 67 14 26 155 1 1 32 7 42 53 7 77 117 9 24 82 16 12 158 4 46 42 8 19 85 13 79 46 13 20 87 14 33 83 8 5 9 17 15 88 2 49 120 1 62 108 18 37 1 12 14 63 0 58 65 17 89 175 7 60 72 7 13 174 5 40 22 9 62 85 1 95 62 12 0 2 4 92 119 7 49 132 5 72 16 9 91 66 13 46 56 18 81 41 0 22 114 14 44 138 0 24 134 3 68 86 2 101 123 10 88 90 13 90 96 7 56 3 8 107 186 0 104 108 13 74 101 5 29 140 12 103 82 1 4 55 4 105 168 17 19 25 8 42 42 2 86 155 9 56 108 9 50 46 12 59 44 10 34 208 16 19 9 14 42 76 16 0 82 17 48 77 14 29 4 4 102 145 9 9 81 8 74 207 11 42 63 10 130 45 10 100 192 13 76 215 5 106 17 6 90 82 15 123 88 17 95 150 18 0 72 16 144 133 14 112 124 1 40 82 0 39 68 10 89 217 15 121 79 0 25 149 8 96 30 0 17 193 9 23 71 14 35 160 18 67 189 5 154 231 0 123 166 16 132 97 8 120 13 8 55 90 6 99 41 12 30 77 0 83 12 12 136 62 18 42 152 4 151 19 9 26 247 17 142 67 5 79 67 0 57 179 9 71 66 5 99 99 4 106 21 15 129 81 9 132 45 13 96 123 1 69 60 12 77 233 8 93 254 0 117 72 5 76 46 15 66 212 5 123 80 15 173 216 6 71 245 17 162 156 18 70 230 4 49 8 13 168 117 0 77 0 6 5 159 3 11 273 9 104 109 8 156 168 7 12 162 12 106 259 0 191 266 12 60 137 15 162 41 1 81 204 5 115 239 7 107 89 13 75 53 7 157 279 4 59 236 0 119 154 12 125 276 13 163 143 0 208 115 14 47 63 0 33 237 5 174 267 9 29 142 0 103 37 14 208 143 14 45 270 15 155 74 8 152 85 16 41 48 0 90 163 13 220 118 2 152 67 3 121 20 6 111 171 16 114 185 0 131 216 9 177 151 6 123 83 4 164 24 6 212 219 5 157 133 1 188 22 7 192 270 1 80 34 14 108 115 13 216 258 3 113 70 17 96 161 18 8 180 10 120 170 1 152 271 6 9 1 18 87 202 3 72 1 6 81 86 9 197 66 2 104 93 2 20 276 10 48 188 14 192 67 3 153 214 9 190 235 15 244 143 6 234 121 12 161 172 7 59 169 13 252 297 9 71 141 13 255 173 14 203 10 17 187 244 18 145 101 9 263 183 7 54 263 13 23 102 0 261 299 13 85 133 8 250 158 0 146 43 7 93 89 18 100 221 12 210 224 16 106 194 5 52 277 15 203 156 9 36 98 3 108 117 18 12 257 5 108 284 6 39 299 1 83 202 0 102 272 7 39 247 17 72 48 12 3 229 9 266 32 11 170 238 9 114 66 18 233 33 5 37 12 10 128 19 18 176 267 12 255 35 1 180 161 5 108 249 9


    public int mutateChance = 10;
    Random r = new Random();

    private Scanner scanner = new Scanner("Data");


    public static void main(String[] args) {
        MainCartesian m = new MainCartesian();
        m.run();
    }

    public void run(){
        Tree.graphs = scanner.read();
        MainGeneral.printMinimalColor();
        Genotype champion = new Genotype();
        //champion.printGenes();
        //System.out.println(champion.toString());
        champion.evaluate();
        System.out.println(champion.getFitness());
        Genotype child = new Genotype(mutate(champion));
        child.evaluate();

        //for (int i = 0; i < 1000; i++) {
        while(true){
            if(child.getFitness()<=champion.getFitness()){

                if(child.getFitness()<champion.getFitness()){
                    System.out.println(child.getFitness());
                    child.soutGenes();
                }

                champion = child;
            }
            child = new Genotype(mutate(champion));
            child.evaluate();
            //System.out.println(child.getFitness());
        }
    }

    public int[][] mutate(Genotype parent){
        int[][] child = parent.genes.clone();
        for (int i = 0; i < child.length; i++) {
            if(r.nextInt(100)<mutateChance){ //mutate the gene
                switch (r.nextInt(3)){
                    case 0:
                        child[i][0] = i==0?0:r.nextInt(i);
                        break;
                    case 1:
                        child[i][1] = (i+Genotype.maxLookBack>Genotype.size)?r.nextInt(Genotype.size):r.nextInt(i+Genotype.maxLookBack);
                        break;
                    case 2:
                        child[i][2] = r.nextInt(Genotype.numOfFunctions);
                }
            }
        }
        return child;
    }

}
