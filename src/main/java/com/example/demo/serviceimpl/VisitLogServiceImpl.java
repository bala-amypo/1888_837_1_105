@Service
public class VisitLogServiceImpl {

    private final VisitLogRepository visitLogRepository;
    private final VisitorRepository visitorRepository;
    private final HostRepository hostRepository;

    public VisitLogServiceImpl(VisitLogRepository visitLogRepository,
                               VisitorRepository visitorRepository,
                               HostRepository hostRepository) {
        this.visitLogRepository = visitLogRepository;
        this.visitorRepository = visitorRepository;
        this.hostRepository = hostRepository;
    }

    public VisitLog checkIn(Long visitorId, Long hostId, String purpose) {
        VisitLog log = new VisitLog();
        log.setVisitor(visitorRepository.findById(visitorId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found")));
        log.setHost(hostRepository.findById(hostId)
                .orElseThrow(() -> new ResourceNotFoundException("Host not found")));
        log.setPurpose(purpose);
        log.setAccessGranted(true);
        return visitLogRepository.save(log);
    }

    public VisitLog checkOut(Long id) {
        VisitLog log = visitLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));
        if (log.getCheckOutTime() != null)
            throw new IllegalStateException("Visitor not checked in");
        log.setCheckOutTime(java.time.LocalDateTime.now());
        return visitLogRepository.save(log);
    }
}
