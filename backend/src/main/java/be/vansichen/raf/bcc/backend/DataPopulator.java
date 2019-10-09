package be.vansichen.raf.bcc.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataPopulator implements ApplicationRunner {

    @Autowired
    private MembersRepository memberRepository;
    @Autowired
    private RidesRepository ridesRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Member raf, ludo, martine, benny, erik;
        memberRepository.save(raf = new Member("Raf VANSICHEN"));
        memberRepository.save(ludo = new Member("Ludo MIGNOLET"));
        memberRepository.save(martine = new Member("Martine DECOUTERE"));
        memberRepository.save(benny = new Member("Benny PRIEMEN"));
        memberRepository.save(erik = new Member("Erik WAGEMANS"));

        ridesRepository.save(new Ride(LocalDate.of(2019, 10, 6), "Citadel Luik", raf, ludo));
        ridesRepository.save(new Ride(LocalDate.of(2019, 10, 6), "Eghezée", martine, erik));
        ridesRepository.save(new Ride(LocalDate.of(2019, 10, 6), "Boxbergheide", benny));
        ridesRepository.save(new Ride(LocalDate.of(2019, 10, 6), "Velroux"));

    }
}
