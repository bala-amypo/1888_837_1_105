@Service
public class AppointmentServiceImpl {

    private final AppointmentRepository appointmentRepository;
    private final VisitorRepository visitorRepository;
    private final HostRepository hostRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository,
                                  VisitorRepository visitorRepository,
                                  HostRepository hostRepository) {
        this.appointmentRepository = appointmentRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    public Appointment createAppointment(Long visitorId, Long hostId, Appointment a) {
        if (a.getAppointmentDate().isBefore(java.time.LocalDate.now()))
            throw new IllegalArgumentException("appointmentDate cannot be past");

        a.setVisitor(visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found")));
        a.setHost(hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found")));

        return appointmentRepository.save(a);
    }
}
