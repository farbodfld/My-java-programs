class amarvaargham {
    public void showsood() {
        tolidkonande.getSood();
    }

    public long showkharjemoshtari() {
        return moshtari.kharjemoshtari;
    }

    public long showhajmejabejashode() {
        return barbar.hajmesefareshat;
    }

    public void kalahayekharidarishode() {
        for (int i = 0; i < moshtari.ajnasekharidarishode.size(); i++) {
            System.out.println(moshtari.ajnasekharidarishode.get(i));
        }
    }

    public void sefareshatejabejashode() {
        for (int i = 0; i < barbar.sefareshatersalshode.size(); i++) {
            System.out.println(barbar.sefareshatersalshode.get(i));
        }
    }

    public void kalahayefrookhteshode() {
        for (int i = 0; i < moshtari.ajnasekharidarishode.size(); i++) {
            System.out.println(moshtari.ajnasekharidarishode.get(i));
        }
    }
}
