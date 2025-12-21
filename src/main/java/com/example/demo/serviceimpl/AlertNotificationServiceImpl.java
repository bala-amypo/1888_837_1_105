@Service
public class AlertNotificationServiceImpl {

    private final AlertNotificationRepository alertRepository;
    private final VisitLogRepository visitLogRepository;

    public AlertNotificationServiceImpl(AlertNotificationRepository alertRepository,
                                        VisitLogRepository visitLogRepository) {
        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }

    public AlertNotification send(Long visitLogId) {
        if (alertRepository.findByVisitLogId(visitLogId).isPresent())
            throw new IllegalArgumentException("Alert already sent");

        VisitLog log = visitLogRepository.findById(visitLogId)
                .orElseThrow(() -> new ResourceNotFoundException("Visitor not found"));

        AlertNotification alert = new AlertNotification();
        alert.setVisitLog(log);
        alert.setSentTo(log.getHost().getEmail());
        alert.setAlertMessage("Visitor arrived");

        return alertRepository.save(alert);
    }
}
